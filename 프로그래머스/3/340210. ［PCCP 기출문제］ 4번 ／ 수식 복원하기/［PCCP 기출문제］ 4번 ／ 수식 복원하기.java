import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {       
        List<String> list = new ArrayList<>();
        boolean[] digits = new boolean[10];
        for (int i = 2; i <= 9; i++) {
            digits[i] = true;
        }
        for (String e : expressions) {
            StringTokenizer st = new StringTokenizer(e);
            int A = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            st.nextToken();
            String X = st.nextToken();
            
            if (X.equals("X")) {
                list.add(e);
                
                int tmpA = A;
                int tmpB = B;
                for (int d = 2; d <= 9; d++) {
                    while (tmpA > 0 || tmpB > 0) {
                        if (tmpA % 10 >= d || tmpB % 10 >= d) {
                            digits[d] = false;
                            break;
                        }

                        tmpA /= 10;
                        tmpB /= 10;
                    }
                }
            }
            else {
                int iX = Integer.parseInt(X);
                
                for (int d = 2; d <= 9; d++) {
                    if (digits[d] == false) {
                        continue;
                    }
                    
                    int tmpA = A;
                    int tmpB = B;
                    int tmpX = iX;
                    int dA = 0;
                    int dB = 0;
                    int dX = 0;
                    
                    int n = 1;
                    while (tmpA > 0) {
                        if (tmpA % 10 >= d) {
                            digits[d] = false;
                            break;
                        }
                        
                        dA += (tmpA % 10) * n;
                        tmpA /= 10;
                        n *= d;
                    }
                    
                    n = 1;
                    while (tmpB > 0) {
                        if (tmpB % 10 >= d) {
                            digits[d] = false;
                            break;
                        }
                        
                        dB += (tmpB % 10) * n;
                        tmpB /= 10;
                        n *= d;
                    }
                    
                    n = 1;
                    while (tmpX > 0) {
                        if (tmpX % 10 >= d) {
                            digits[d] = false;
                            break;
                        }
                        
                        dX += (tmpX % 10) * n;
                        tmpX /= 10;
                        n *= d;
                    }
                    
                    if (!digits[d]) {
                        continue;
                    }
                    
                    if (op.equals("+") && dA + dB == dX) {
                        digits[d] = true;
                    }
                    else if (op.equals("-") && dA - dB == dX) {
                        digits[d] = true;
                    }
                    else {
                        digits[d] = false;
                    }
                }
                
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Set<Integer> candidate = new HashSet<>();
            String e = list.get(i);
            StringTokenizer st = new StringTokenizer(e);
            int A = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder(A + " " + op + " " + B + " = ");
            
            for (int d = 2; d <= 9; d++) {
                if (!digits[d]) {
                    continue;
                }
                
                int tmpA = A;
                int tmpB = B;
                int next = 0;
                Deque<Integer> dq = new ArrayDeque<>();
                
                if (op.equals("+")) {
                    while (tmpA > 0 || tmpB > 0) {
                        int sum = (tmpA % 10) + (tmpB % 10) + next;
                        if (sum >= d) {
                            sum %= d;
                            next = 1;
                        }
                        else {
                            next = 0;
                        }
                        
                        dq.add(sum);
                        
                        tmpA /= 10;
                        tmpB /= 10;
                    }
                    if (next == 1) {
                        dq.add(1);
                    }
                }
                else {
                    while (tmpA > 0 || tmpB > 0) {
                        int sum = (tmpA % 10) - (tmpB % 10) + next;
                        if (sum < 0) {
                            sum += d;
                            next = -1;
                        }
                        else {
                            next = 0;
                        }
                        
                        dq.add(sum);
                        
                        tmpA /= 10;
                        tmpB /= 10;
                    }
                }
                dq.add(0);
                
                StringBuilder result = new StringBuilder();
                while (!dq.isEmpty()) {
                    result.append(dq.removeLast());
                }
                
                candidate.add(Integer.parseInt(result.toString()));
            }
            
            if (candidate.size() == 1) {
                for (int n : candidate) {
                    sb.append(n);
                    break;
                }
            }
            else {
                sb.append("?");
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}