package stack;

public class Sol0402 {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        int startIndex = 0;
        char min;
        for (int i = 1; i <= num.length() - k; i++) {   //choose n-k digits num
            min = '9' + 1;

            if (startIndex == k + i - 1) {
                sb.append(num.substring(startIndex));
                break;
            }

            for (int j = startIndex; j < k + i; j++) {
                if (num.charAt(j) < min) {
                    min = num.charAt(j);
                    startIndex = j;
                }
            }
            sb.append(min);
            startIndex++;
        }

        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }

        return "0";
    }

    public static void main(String[] args) {
        String[] testStrings = {
                "1432219",
                "10200",
                "10"
        };

        int[] testKs = {3, 1, 2};

        Sol0402 sol0402 = new Sol0402();
        for (int i = 0; i < testStrings.length; i++) {
            System.out.println(sol0402.removeKdigits(testStrings[i], testKs[i]));
        }
    }
}
