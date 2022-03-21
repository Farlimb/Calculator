calc gramatika
E->T {"+" | "-" T}
T->F{"*" | "/"F}
F->["-"]S
S->cislo | "("E")"
