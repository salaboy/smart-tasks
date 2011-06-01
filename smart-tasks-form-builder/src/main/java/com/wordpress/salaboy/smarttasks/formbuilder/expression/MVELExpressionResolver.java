/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.expression;

import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;

/**
 *
 * @author esteban
 */
public class MVELExpressionResolver extends ExpressionResolver {

    @Override
    public Object resolveExpression(String expression, MetaTask metaTask,
            Map<String, ExternalData> contexts) {
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
        else if(context.equals("in")){
        	if (metaTask.getInputs() != null) {
        		return MVEL.eval(realExpression,metaTask.getInputs());
        	}
        	return null;
        }
        else if(context.equals("ext")) {
            if (contexts != null) {
                return MVEL.eval(realExpression, contexts, this.getPossibleParameters(metaTask, contexts));
            }
            return null;
        }
        else{
            throw new IllegalArgumentException("Unsupported context \""+context+"\" in "+expression);
        }
    }
    
    private Map<String, Object> getPossibleParameters(MetaTask metaTask,
            Map<String, ExternalData> contexts) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("task", metaTask.getTask());
        params.put("", metaTask.getTaskAbstract());
        params.put("in", metaTask.getInputs());
        params.put("ext", contexts);
        return params;
    }
}
