package exam;

public class Aarray2DEx2 {

	public static void main(String[] args) {
		int[][] score = {
	            {100, 100, 100},
	            {20, 20, 20},
	            {30, 30, 30},
	            {40, 40, 40},
	            {50, 50, 50}
	        };
	        
	        int kor = 0;
	        int eng = 0;
	        int math = 0;
	        
	        System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
	        System.out.println("====================================================");
	        
	        for (int i = 0; i < score.length; i++) {
	            int sum = 0;
	            float avg = 0.0f;
	            
	            kor += score[i][0];
	            eng += score[i][1];
	            math += score[i][2];
	            
	            System.out.print((i + 1) + "\t");
	            
	            for (int j = 0; j < score[i].length; j++) {
	                sum += score[i][j];
	                System.out.print(score[i][j] + "\t");
	            }
	            
	            avg = sum / (float) score[i].length;
	            System.out.println(sum + "\t" + avg);
	        }
	        
	        System.out.println("====================================================");
	        System.out.printf("총점: \t" + kor + "\t" + eng + "\t" + math);
	        
	}

}
