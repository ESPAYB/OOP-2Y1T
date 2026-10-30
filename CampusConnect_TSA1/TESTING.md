# Test and debugging record

## Test inputs and results

Run `tests/mixed_input.txt` as a single five-request session. Each row below identifies one independently checkable behavior. The expected values were calculated from the specified rules. **Actual results are pending execution in NetBeans or JDeveloper**; fill them in from the output before submitting the testing evidence. Do not copy predicted values into the actual column without checking them.

| Test | Input or scenario | Expected result | Actual result |
| --- | --- | --- | --- |
| T1 normal request | Ticket 4: Dan Lim, ADVISING, priority 3 | Accepted; 4 working days | Pending IDE run |
| T2 invalid category | Ticket 1 enters `library`, then ` enrollment ` | First entry rejected and category re-prompted; accepted as ENROLLMENT | Pending IDE run |
| T3 priority boundaries and invalid text | Ticket 2 enters `0`, `6`, `two`, then `1` | Three re-prompts; priority 1 accepted; 2 days | Pending IDE run |
| T4 category and priority rule | Ticket 3: PAYMENT, priority 5; Ticket 1: ENROLLMENT, priority 5 | PAYMENT remains 1 day; ENROLLMENT becomes 2 days | Pending IDE run |
| T5 summary | All five requests in `mixed_input.txt` | Counts 1/1/1/2 in category order; first priority-5 ticket is Ada Reyes; (2+2+1+4+3)/5 = 2.40 days | Pending IDE run |
| T6 required text and trimming | Ticket 1 includes a blank ID followed by padded ID/name/concern | Blank ID re-prompts; saved strings have no outer spaces; only one ticket is accepted | Pending IDE run |

If the IDE reads typed input interactively, the prompts and typed lines will look different from the redirected-output example.

## Logical defect and tracing exercise

Classification: **logical**. During design, an integer-division version of the summary expression would have been:

```java
double averageDays = totalDays / studentIds.length;
```

Variable trace using the supplied five requests with day estimates `2, 2, 1, 4, 3`: `totalDays = 12`, `studentIds.length = 5`, expected `12 / 5 = 2.40`. With both operands as `int`, Java evaluates the division as the integer `2` before assigning it to `double`, so that defective expression displays `2.00`. The checked source corrects the expression with `(double) totalDays / studentIds.length`. This is a **reasoned variable trace**, not a claim that a breakpoint was used or that the defective build was run. For observed debugging evidence in the IDE, temporarily set a breakpoint on the average expression, inspect `totalDays` and `studentIds.length` using the supplied fixture, step over the expression with and without the cast, and capture both displayed values. Restore the corrected expression before submission.

The supplied fixture deliberately totals 12, exposing the difference between 2.40 and the defective 2.00. Save the observed debugger output here after the IDE session.

## Build and run record

- Clean build in NetBeans or JDeveloper: **Pending IDE run**.
- Run output versus `tests/expected_output.txt`: **Pending IDE run**.
- Screenshot or output log filename: **Pending IDE run**.
