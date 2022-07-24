class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    x += 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
            }
        }

        return (x == 0 && y == 0);
    }
}
