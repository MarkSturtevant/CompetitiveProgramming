import java.util.*;
import java.io.*;

public class Interpreter {

    // ACTIVE PROGRAM: "Coordinated" Code Runner

    static int currentLine;
    static List<String> lines;
    static List<Variable> variables;

    public static void main(String[] unused) throws Exception {

        Scanner scanner = new Scanner(new File("inputCoordTestCase.txt")); // test case
        BufferedReader reader = new BufferedReader(new FileReader("inputCoordinated.txt")); // code

        try {
            run(scanner, reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
            scanner.close();
        }
    }

    private static void run(Scanner scanner, BufferedReader reader) throws Exception {
        lines = new ArrayList<>(); variables = new ArrayList<>();
        currentLine = 0;

        String next = "";
        while ((next = reader.readLine()) != null)
            lines.add(next.trim());

        while (currentLine < lines.size()) {
            if (lines.get(currentLine).equals("") || lines.get(currentLine).trim().startsWith("//")) {
                ++currentLine;
                continue;
            }
            String[] args = lines.get(currentLine).split(" ");
            switch(args[0]) {
                case "PUT":
                    if (! scanner.hasNextInt())
                        throw new Exception("(Line " + currentLine + ") Nothing to input.");
                    new Variable(args[1], scanner.nextInt());
                    break;
                case "PRINT":
                    Variable get = find(0, 1);
                    if (get == null)
                        System.out.println("N/A");
                    else System.out.println(get.value);
                    break;
                case "EXIT":
                    Variable get2 = find(1, 1);
                    if (get2 != null)
                        variables.remove(get2);
                    break;
                case "COMPARE":
                    Variable v1 = find(1, 0), v2 = find(1, 2);
                    int val1 = v1 == null ? 0 : v1.value;
                    int val2 = v2 == null ? 0 : v2.value;
                    new Variable(args[1], val2 - val1);
                    break;
                case "LOOP":
                    Variable get4 = find(0, 2);
                    if (get4 != null && get4.value > 0)
                        get4.value--;
                    else {
                    	int stack2 = 1;
                    	while (true) {
                    		if (++currentLine >= lines.size())
                                throw new Exception("(Line " + currentLine + ") Missing ENDLOOP statement.");
                            else if (lines.get(currentLine).split(" ")[0].equals("ENDLOOP")) {
                                if (--stack2 == 0) {
                                    --currentLine;
                                    break;
                                }
                            } else if (lines.get(currentLine).split(" ")[0].equals("LOOP"))
                                ++stack2;
                        }
                    }
                        
                    break;
                case "ENDLOOP":
                    Variable get5 = find(0, 2);
                    int stack = 1;
                    if (get5 != null && get5.value > 0) {
                        while (true) {
                            if (--currentLine < 0)
                                throw new Exception("(Line ?) Missing LOOP statement.");
                            else if (lines.get(currentLine).split(" ")[0].equals("LOOP")) {
                                if (--stack == 0) {
                                    --currentLine;
                                    break;
                                }
                            } else if (lines.get(currentLine).split(" ")[0].equals("ENDLOOP"))
                                ++stack;
                        }
                    }
                    break;
                case "MOVE":
                    Variable get3 = find(args[1]);
                    if (get3 == null)
                        throw new Exception("(Line " + currentLine + ") Variable " + args[1] + " not found.");
                    if (args[2].equals("DOWN"))
                        move(get3, get3.x, get3.y + 1);
                    else if (args[2].equals("UP"))
                        move(get3, get3.x, get3.y - 1);
                    else if (args[2].equals("RIGHT"))
                        move(get3, get3.x + 1, get3.y);
                    else if (args[2].equals("LEFT"))
                        move(get3, get3.x - 1, get3.y);
                    else throw new Exception("(Line " + currentLine + ") Improper direction.");
                    break;
                case "DEBUG":
                    System.out.println("Line Number: " + currentLine);
                    System.out.printf("%10s | %10s\n", find(0, 0), find(1, 0));
                    System.out.printf("%10s | %10s\n", find(0, 1), find(1, 1));
                    System.out.printf("%10s | %10s\n", find(0, 2), find(1, 2));
                    break;
                default:
                    throw new Exception("(Line " + currentLine + ") Improper command.");
            }
            currentLine++;
        }
    }

    private static void move(Variable var, int x, int y) throws Exception {
        if (x < 0 || y < 0 || x > 1 || y > 2)
            throw new Exception("(Line " + currentLine + ") Box moved out of bounds.");
        Variable toPlaceOn = find(x, y);
        if (toPlaceOn == null) {
            var.x = x;
            var.y = y;
        }
        else {
            variables.remove(var);
            toPlaceOn.value += var.value;
        }
    }

    private static Variable find(int x, int y) {
        for (Variable var : variables)
            if (var.x == x && var.y == y)
                return var;
        return null;
    }

    private static Variable find(String name) {
        for (Variable var : variables)
            if (var.name.equals(name))
                return var;
        return null;
    }

    private static class Variable {
        String name;
        int value;
        int x, y;

        public Variable(String name, int value) throws Exception {
            if (find(name) != null)
                throw new Exception("(Line " + currentLine + ") Variable " + name + " already in use!");
            this.name = name;
            this.value = value;
            variables.add(this);
            this.x = this.y = -1;
            move(this, 0, 0);
        }

        public String toString() {
            return name + " (" + value + ")";
        }
    }

}