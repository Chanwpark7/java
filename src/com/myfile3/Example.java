package com.myfile3;

import java.util.function.ToDoubleFunction;

class Student{
   public String n;
   public int englishScore;
   public int mathScore;
   
   public Student(String n, int englishScore, int mathScore) {
      this.n = n;
      this.englishScore = englishScore;
      this.mathScore = mathScore;
   }
   
   public int getEnglishScore() {
      return englishScore;
   }
   
   public int getMathScore() {
      return mathScore;
   }
}

public class Example {
   
   private static Student[] students = {
         new Student("d", 3, 3),
         new Student("s", 2, 10)
   };
   
   static double avg(ToDoubleFunction<Student> fc) {
      int sum = 0;
      for(Student student : students) {
         sum += fc.applyAsDouble(student);
      }
      double avg = (double) sum / students.length;
      return avg;
   }

   public static void main(String[] args) {
      double englishAvg = avg( s -> s.getEnglishScore() );
       System.out.println("영어 평균 점수: " + englishAvg);
       double mathAvg = avg( s -> s.getMathScore() );
       System.out.println("수학 평균 점수: " + mathAvg);
   }

}