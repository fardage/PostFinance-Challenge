package ch.tseng;

public class FloydWarshallAlgorithm {
    public double[][] getNewMatrix(double[][] adjacencyMatrix) {
        for (int k = 0; k < adjacencyMatrix.length; k++)
            for (int j = 0; j < adjacencyMatrix.length; j++)
                for (int i = 0; i < adjacencyMatrix.length; i++)
                    if (adjacencyMatrix[i][k] + adjacencyMatrix[k][j] < adjacencyMatrix[i][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                    }
        return adjacencyMatrix;
    }

    public void printMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; ++col) {
                if (matrix[row][col] == Double.POSITIVE_INFINITY)
                    System.out.print(String.format("%6s", "INF"));
                else
                    System.out.print(String.format("%6.2f", matrix[row][col]));
            }
            System.out.println();
        }
    }
}
