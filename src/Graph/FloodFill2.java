package Graph;
//https://leetcode.com/problems/flood-fill/
public class FloodFill2 {
    private final int [][] DIRS = {{-1,0}, {1,0}, {0, -1}, {0, 1}};

    //dfs or bfs, the same
    public int [][] floodFill(int [][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    //check if current position has same color as old color;
    //if true, change it to new color and check all its four directions
    private void dfs(int [][] images, int i, int j, int old, int newColor) {
        if (i < 0 || i >= images.length || j < 0 || j >= images[0].length
                || images[i][j] != old || images[i][j] == newColor) {
            return;
        }

        images[i][j] = newColor;
        for (int [] dir : DIRS) {
            dfs(images, i + dir[0], j + dir[1], old, newColor);
        }


    }
}
