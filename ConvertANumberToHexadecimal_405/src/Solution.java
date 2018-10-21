class Solution {
    public String toHex(int num) {
        if(num == 0)
            return "0";
        boolean negative = num < 0;
        if(negative)
            num = (1 << 31) + num;

        StringBuilder sb = new StringBuilder();
        int hexCount = 0, currHexDigit = -1, prevHexDigit = -1;
        while(num != 0) {
            currHexDigit = num & 15;
            if(prevHexDigit != -1)
                sb.append(getHexDigit(prevHexDigit));
            hexCount++;
            prevHexDigit = currHexDigit;
            num >>= 4;
        }

        if(!negative)
            sb.append(getHexDigit(currHexDigit));
        else if(hexCount < 8) {
            if(currHexDigit != -1)
                sb.append(getHexDigit(currHexDigit));
            while(++hexCount < 8)
                sb.append('0');
            sb.append('8');
        }
        else {
            currHexDigit += 8;
            sb.append(getHexDigit(currHexDigit));
        }

        return sb.reverse().toString();
    }

    private char getHexDigit(int x) {
        return x < 10 ? (char)('0' + x) : (char)('a' + (x - 10));
    }
}