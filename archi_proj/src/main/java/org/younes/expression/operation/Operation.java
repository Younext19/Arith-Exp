package org.younes.expression.operation;

import org.younes.arith.operartion.ArithmBinaryOperation;
import org.younes.arith.operartion.ArithmConst;
import org.younes.arith.operartion.ArithmUnaryOperation;
import org.younes.function.operation.FunctionBinaryOperation;
import org.younes.function.operation.FunctionConst;
import org.younes.function.operation.FunctionUnaryOperation;
import org.younes.function.operation.FunctionVariable;
import org.younes.regexp.operation.RegexpBinaryOperation;
import org.younes.regexp.operation.RegexpConst;
import org.younes.regexp.operation.RegexpUnaryOperation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "operation")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ArithmConst.class, name = "ArithmConst"),
    @JsonSubTypes.Type(value = ArithmBinaryOperation.class, name = "ArithmBinaryOperation"),
    @JsonSubTypes.Type(value = ArithmUnaryOperation.class, name = "ArithmUnaryOperation"),

    @JsonSubTypes.Type(value = FunctionConst.class, name = "FunctionConst"),
    @JsonSubTypes.Type(value = FunctionBinaryOperation.class, name = "FunctionBinaryOperation"),
    @JsonSubTypes.Type(value = FunctionUnaryOperation.class, name = "FunctionUnaryOperation"),
    @JsonSubTypes.Type(value = FunctionVariable.class, name = "FunctionVariable"),

    @JsonSubTypes.Type(value = RegexpConst.class, name = "RegexpConst"),
    @JsonSubTypes.Type(value = RegexpBinaryOperation.class, name = "RegexpBinaryOperation"),
    @JsonSubTypes.Type(value = RegexpUnaryOperation.class, name = "RegexpUnaryOperation")
})

public interface Operation {
    String toReversePolishNotation();
}
