public class Main{

	// precondition: Map must be a rectangular array, and map/row/col must be defined.
	// postcondition: returns a boolean: true if there is a way to the edge of the map following the lowest number next door, false otherwise
    public static boolean canFlowOff(int[][] map, int row, int col){
        

        if (row < 0 || row > map.length -1 || col < 0 || col > map[0].length-1) return false;

        boolean end = false;
        if (row-1 < 0 || row == map.length-1 || col-1 < 0 || col+1 > map[0].length-1){
           return true;
        }

        int cur = map[row][col];

        if (cur > map[row-1][col] && !end){
            end = canFlowOff(map, row - 1, col);
        }
        if (cur > map[row+1][col] && !end){
            end =canFlowOff(map, row + 1, col);
        }
        if (cur > map[row][col-1] && !end){
            end = canFlowOff(map, row, col-1);
        }
        if (cur > map[row][col+1] && !end){
            end = canFlowOff(map, row, col+1);
        }

        return end;
    }

    public static void main(String[] args){
        
        int[][] map = {
			{100, 99, 200, 200, 200, 200, 200, 200, 200, 200}, 
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 200},
			{200, 97, 96, 200, 200, 200, 200, 200, 200, 200},
			{200, 200, 95, 200, 200, 200, 85, 84, 83, 200},
			{200, 200, 94, 93, 92, 200, 86, 200, 82, 200},
			{200, 150, 200, 200, 91, 200, 87, 200, 81, 200},
			{200, 200, 200, 200, 90, 89, 88, 200, 80, 200},
			{200, 150, 100, 200, 200, 200, 200, 200, 79, 200},
			{200, 200, 200, 200, 200, 200, 200, 200, 78, 77},
			{200, 98, 200, 200, 200, 200, 200, 200, 200, 76}
        };
        System.out.println(canFlowOff(map, 9, 9));

        int[][] map1 = {
            {99, 99, 99, 99, 99},
            {99, 90, 80, 70, 99},
            {99, 99, 99, 60, 99},
            {99, 99, 99, 50, 99},
            {99, 99, 99, 40, 99}
        };

        System.out.println(canFlowOff(map1, 1, 1));

        int[][] map2 = {
            {99, 99, 99, 99, 99, 99, 99},
            {99, 90, 80, 70, 99, 99, 99},
            {99, 99, 99, 60, 99, 99, 99},
            {99, 99, 99, 99, 99, 99, 99},
            {99, 99, 99, 99, 99, 99, 99}
        };

        System.out.println(canFlowOff(map2, 1, 1));

        int[][] map3 = {
            {99, 99, 99, 99, 99, 99},
            {99, 70, 99, 99, 99, 99},
            {99, 80, 90, 60, 50, 40},
            {99, 99, 85, 99, 99, 99},
            {99, 99, 99, 99, 99, 99},
            {99, 99, 99, 99, 99, 99}
        };

        System.out.println(canFlowOff(map3, -1, 2));
    }

    

}
