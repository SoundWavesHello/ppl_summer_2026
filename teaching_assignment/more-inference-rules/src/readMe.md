Some logistics:
- Due dates
    - PS3 is due on Wednesday.
    - PS4 is available, and due on Monday
    - Project 1 is also due on Monday
- Long view
    - Project 2 should be available next Friday (similar 2 week time deadline)
    - Mid-term 2 will be ~3 weeks from now
    - After that, it's just the final

Plan for the week
- Clarification on any confusing topics and more practice with inference rules
- Lettuce and the Abstract Syntax Tree
- Lettuce math logic

Plan for today
- Mid-term 1 review
- More inference rule work
- Might look at the AST if we have time

BNF Grammar that we're working with today:

$$\begin{array}{lll}
e &\Rightarrow& v \\
&|& sum(e) \\
&|& e_1 + e_2 & \texttt{add e2 to each element of e1}\\
&|& e_1 \leftarrow e_2 & \texttt{insert e2 to e1}\\
&|& isOrdered
(e) \\
&|& e_1\;delete\;e_2 \\
&|& e_1 \rightarrow e_2 \\
\\
v & \Rightarrow & vl \\
& | & b \\
&|& n \\
&|& ERROR \\
\\
vl &\Rightarrow& X \\
&|& n \rightarrow vl \\
\\
&& \texttt{n is a number} \\
&& \texttt{b is a boolean} \\
\end{array}$$
