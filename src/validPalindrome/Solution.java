package validPalindrome;

public class Solution {

    final private String url = "https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/";

    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail){
            if ((s.charAt(head) <= 64 ||
                    (s.charAt(head) >= 91 && s.charAt(head) <= 96) ||
                    s.charAt(head) >= 123) &&
                    !(s.charAt(head) >= 48 && s.charAt(head) <= 57)
            ){
                head++;
                continue;
            }

            if ((s.charAt(tail) <= 64 ||
                    (s.charAt(tail) >= 91 && s.charAt(tail) <= 96) ||
                    s.charAt(tail) >= 123) &&
                    !(s.charAt(tail) >= 48 && s.charAt(tail) <= 57)
            ){
                tail--;
                continue;
            }
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);

            if (headChar <= 90 && headChar >= 65){
                headChar += 32;
            }
            if (tailChar <= 90 && tailChar >= 65){
                tailChar += 32;
            }

            if (headChar != tailChar){
                return false;
            }

            head++;
            tail--;
        }
        return true;
    }

    class BestRuntimeSolution {
        public boolean isPalindrome(String s) {
            int i=0;
            int j=s.length()-1;
            while(i<j)
            {
                while(i<j && !isalphanumeric(s.charAt(i)))
                {
                    i++;//if the char is not alphanumeric then move left
                }
                while(i<j && !isalphanumeric(s.charAt(j)))
                {
                    j--;
                }
                if(lowercase(s.charAt(i))!=lowercase(s.charAt(j)))
                {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
        public boolean isalphanumeric(char c)
        {
            if(c>='0'&&c<='9')
            {
                return true;
            }
            if(c>='a'&&c<='z'||c>='A'&&c<='Z')
            {
                return true;
            }

            return false;

        }
        public char lowercase(char c)
        {
            if(c>='A' && c<='Z')
            {
                return (char)(c+('a'-'A'));
            }
            return c;
        }
    }

    class BestMemorySolution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int start = 0;
            int last = s.length() - 1;
            while(start <= last) {
                char currFirst = s.charAt(start);
                char currLast = s.charAt(last);
                if (!Character.isLetterOrDigit(currFirst )) {
                    start++;
                } else if(!Character.isLetterOrDigit(currLast)) {
                    last--;
                } else {
                    if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                        return false;
                    }
                    start++;
                    last--;
                }
            }
            return true;
        }
    }
}
