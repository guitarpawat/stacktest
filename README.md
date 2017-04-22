# Stack Test
*OOP2 LAB11*

This program contains the tests for two type of stacks in the problem.

## Test results

|Tests|Stack Type 0|Stack Type 1|
|:---:|---|---|
|**testEmptyStack**|**Passed**|**Failed:** isFull when size=0 must be true|
|**testNormalEmptyStack**|**Passed**|**Passed**|
|**testPop**|**Passed**|**Failed:** This stack size is invalid expected same:<2> was not:<1>|
|**testPeek**|**Passed**|**Failed:** Peek must not remove the object expected:<1> but was:<0>|
|**testPush**|**Passed**|**Failed:** Invalid size of stack after push expected:<1> but was:<0>|
|**testSize**|**Passed**|**Passed**
|**testIllegalStateException**|**Failed:** Expected exception: java.lang.IllegalStateException|**Failed:** Expected exception: java.lang.IllegalStateException|
|**testIllegalArgumentException**|**Passed**|**Failed:** Expected exception: java.lang.IllegalArgumentException|
|**testIllegalStateExceptionSize0**|**Failed:** Expected exception: java.lang.IllegalStateException java.lang.IllegalStateException|**ERROR:** Unexpected exception, expected<java.lang.IllegalStateException> but was<java.util.EmptyStackException>|
|**testEmptyStackException0**|**Passed**|**Passed**|
|**testEmptyStackException**|**Passed**|**Passed**|
|**testIsFull**|**Passed**|**Failed:** This stack is full now|
|**testIsEmpty**|**Passed**|**Passed**|
