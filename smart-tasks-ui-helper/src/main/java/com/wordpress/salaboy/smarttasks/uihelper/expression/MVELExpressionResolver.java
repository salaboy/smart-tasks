/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.expression;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;
import org.mvel2.MVEL;

/**
 *
 * @author esteban
 */
public class MVELExpressionResolver extends ExpressionResolver {

    @Override
    public Object resolveExpression(String expression, MetaTask metaTask){
        expression = expression.trim();
        
        if (this.isPlainValue(expression)){
            return expression;
        }
        
        String[] expressionParts = this.getExpressionParts(expression);
        //Just to make it clear, expressionParts[0] is the context and 
        //expressionParts[1] is the real Expression.
        String context = expressionParts[0];
        String realExpression = expressionParts[1];
        
        if (context == null){
            //default context
           return MVEL.eval(realExpression,metaTask.getTaskAbstract());
        } else if(context.equals("meta")){
            return MVEL.eval(realExpression,metaTask);
        }
        else if(context.equals("task")){
           return MVEL.eval(realExpression,metaTask.getTask());
        }
        else{
            throw new IllegalArgumentException("Unsupported context \""+context+"\" in "+expression);
        }
    }
}
