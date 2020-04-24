package com.codeforces.minimal_string;

//problem :: https://codeforces.com/contest/797/problem/C
//blog post ::
//youtube tutorial ::

//don't copy above this line

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            Stack<Character> t = new Stack();
            StringBuilder result = new StringBuilder();
            int idx = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                while ((t.size() > 0) && (t.peek() <= c)) {
                    result.append(t.pop());
                }
                int nextPos = s.indexOf(c, idx);
                while (nextPos >= 0) {
                    while (idx < nextPos) {
                        t.push(s.charAt(idx++));
                    }
                    result.append(c);
                    idx++;
                    nextPos = s.indexOf(c, idx);
                }
            }
            while (t.size() > 0) {
                result.append(t.pop());
            }
            out.println(result.toString());
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                    //tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as delimeter
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}