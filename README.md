<body>

  <h1>Simple Calculator App with Lexer and Parser</h1>

  <p>This repository contains a simple calculator app that utilizes a lexer and parser to evaluate mathematical expressions based on the following rules:</p>

  <pre>
    E -> T {"+" | "-" T}
    T -> F {"*" | "/" F}
    F -> ["-"] S
    S -> number | "(" E ")"
  </pre>

  <h2>Features</h2>

  <ul>
    <li><strong>Lexer:</strong> Tokenizes input mathematical expressions.</li>
    <li><strong>Parser:</strong> Parses tokenized expressions based on the specified grammar rules.</li>
    <li><strong>Calculator:</strong> Evaluates the parsed expressions and produces the result.</li>
  </ul>

  <h2>Example</h2>

  <pre>
    Enter a mathematical expression: 3 + (5 * 2)
    Result: 13
  </pre>

</body>
