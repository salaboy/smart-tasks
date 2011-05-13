/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.uihelper.expression;

import org.mvel2.MVEL;

import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;

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
        //TODO check this "in". This is not an MVEL expression to be evaluated, so it should not be here.
        else if(context.equals("in")){
        	if (metaTask.getInputs() != null && metaTask.getInputs().length>=Integer.parseInt(realExpression)) {
        		return metaTask.getInputs()[Integer.parseInt(realExpression)];
        	}
        	return "";
         }
        else{
            throw new IllegalArgumentException("Unsupported context \""+context+"\" in "+expression);
        }
    }
}
