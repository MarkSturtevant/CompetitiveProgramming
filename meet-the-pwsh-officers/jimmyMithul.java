import java.io.*;
import java.util.*;

public class jimmyMithul {

    public static void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        List<Variable> vars = new ArrayList<>();
        boolean output = false;
        for (int i = 0; i < N; ++i) {
            String raw = reader.readLine().trim();
            String[] next = raw.split("\\s+");
            if (next.length == 0 || next[0].trim().equals(""))
                continue;
            else if (next[0].equals("int")) {
                if (next[3].indexOf(";") > -1)
                    next[3] = next[3].substring(0, next[3].length() - 1);
                Variable value = get(next[3], vars);
                if (value == null) value = new Variable("temp", Integer.parseInt(next[3]));
                vars.add(new Variable(next[1], value.value));
            }
            else if (next[0].startsWith("System.out")) {
                get(raw.substring(raw.indexOf("(") + 1, raw.indexOf(")")).trim(), vars).print();
                output = true;
            }
            else {
                if (next[4].indexOf(";") > -1)
                    next[4] = next[4].substring(0, next[4].length() - 1); // remove the semicolon
                Variable toSet = get(next[0], vars);
                Variable first = get(next[2], vars);
                Variable second = get(next[4], vars);
                if (first == null) first = new Variable("temp", Integer.parseInt(next[2]));
                if (second == null) second = new Variable("temp", Integer.parseInt(next[4]));
                String operator = next[3];
                toSet.value = Variable.operation(operator, first, second);
            }
        }
        if (! output)
            System.out.println("NO OUTPUT");
    }

    private static Variable get(String name, List<Variable> vars) {
        for (Variable var : vars)
            if (var.name.equals(name))
                return var;
        return null;
    }

    public static class Variable {
        int value;
        String name;

        public Variable(String name, int value) {
            this.value = value;
            this.name = name;
        }

        void print() {
            System.out.println(value);
        }

        void set(int val) {
            this.value = val;
        }

        static int operation(String op, Variable v1, Variable v2) {
            switch(op) {
                case "+":
                    return v1.value + v2.value;
                case "-":
                    return v1.value - v2.value;
                case "*":
                    return v1.value * v2.value;
                case "/":
                    return v1.value / v2.value;
                case "%":
                    return v1.value % v2.value;
                default:
                    return Integer.MIN_VALUE;
            }
        }

    }

}
