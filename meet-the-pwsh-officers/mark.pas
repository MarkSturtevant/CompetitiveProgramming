program Solution;

Var
    N, j, I, output : Integer;

begin
    
    readln(N);
    for j:= 1 to N do
    Begin
        readln(I);
        output := I * 133;
        writeln(output);
    End;
End.