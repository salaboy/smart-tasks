/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.salaboy.smarttasks.formbuilder.expression;

import java.util.Map;

import com.wordpress.salaboy.smarttasks.formbuilder.api.ExternalData;
import com.wordpress.salaboy.smarttasks.metamodel.MetaTask;

/**
 *
 * @author esteban
 */
public abstract class ExpressionResolver {

    public final static String EXPRESSION_START_DELIMITER = "#{";
    public final static String EXPRESSION_END_DELIMITER = "}";
    public final static String LIST_START_PLAIN_VALUE_DELIMITER = "[";
    public final static String LIST_END_PLAIN_VALUE_DELIMITER = "]";
    /**
     * Resolves the given expression.
     * @param expression the experssion.
     * @param metaTask the {@link MetaTask} instance to get data if needed by expression.
     * @param contexts a map with different contexts where external information can be found.
     * @return
     */
    public abstract Object resolveExpression(String expression,
            MetaTask metaTask, Map<String, ExternalData> contexts);
    
    /**
     * Returns whether the given expression is a plain value or if it is an expression
     * to be evaluated.
     * @param expression
     * @return 
     */
    protected boolean isPlainValue(String expression){
        return !(expression.startsWith(ExpressionResolver.EXPRESSION_START_DELIMITER) && expression.endsWith(ExpressionResolver.EXPRESSION_END_DELIMITER));
    }
    
    protected boolean isListPlainValue(String expression) {
        return !(expression
                .startsWith(ExpressionResolver.EXPRESSION_START_DELIMITER) && expression
                .endsWith(ExpressionResolver.EXPRESSION_END_DELIMITER))
                && expression
                        .startsWith(ExpressionResolver.LIST_START_PLAIN_VALUE_DELIMITER)
                && expression
                        .endsWith(ExpressionResolver.LIST_END_PLAIN_VALUE_DELIMITER);
    }
    
    protected String removeExpressionDelimiters(String expression){
        expression = expression.replace(ExpressionResolver.EXPRESSION_START_DELIMITER, "");
        expression = expression.replace(ExpressionResolver.EXPRESSION_END_DELIMITER, "");
        
        return expression;
    }
    
    protected String removeListPlainValueDelimiters(String expression){
        expression = expression.replace(ExpressionResolver.LIST_START_PLAIN_VALUE_DELIMITER, "");
        expression = expression.replace(ExpressionResolver.LIST_END_PLAIN_VALUE_DELIMITER, "");
        
        return expression;
    }
    
    /**
     * Returns the 2 possible parts of an expression: the context and the expression
     * itself. 
     * If the context is not defined, the first element of the result is null.
     * The expression passed to this method must contain the expression tags
     * #{}
     * @return 
     */
    protected String[] getExpressionParts(String expression){
        //remove expression delimiters
        expression = this.removeExpressionDelimiters(expression);

        String result[] = new String[2];
        
        String[] expressionParts = expression.split(":");
        
        switch (expressionParts.length){
            case 1:
                result[0] = null;
                result[1] = expression;
                break;
            case 2:
                result[0] = expressionParts[0];
                result[1] = expressionParts[1];
                break;
            default:
                throw new IllegalArgumentException("Malformed expression "+expression);
        }
        
        return result;
    }

}
