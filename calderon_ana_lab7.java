import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
// Version 1: submit by Monday
// 1. generate random (size: 10) lenght, width, height and store in the boxes objects array.
// 2. Do the bubble sort and selection sort.

public class calderon_ana_lab7{
	
	public static void main(String args[]) throws FileNotFoundException{//This will through an exemption if the file is not found
	      
		  int n = 50000;
		  // n = 10000, 20000, 30000, 40000, 50000
	      // Box class Array
	      Box boxes[];			 
	      boxes = randomBoxes(n);

	      Box boxes_bubble[] = new Box[boxes.length];
	      for(int i=0; i<boxes.length; i++) {
	    	  boxes_bubble[i] = new Box(boxes[i].getLength(),boxes[i].getWidth(),boxes[i].getHeight() );
	      }
	      Box boxes_selection[]= new Box[boxes.length];
	      for(int i=0; i<boxes.length; i++) {
	    	  boxes_selection[i] = new Box(boxes[i].getLength(),boxes[i].getWidth(),boxes[i].getHeight() );
	      }
	      
	      Box boxes_arrays_sort[]= new Box[boxes.length];
	      for(int i=0; i<boxes.length; i++) {
	    	  boxes_arrays_sort[i] = new Box(boxes[i].getLength(),boxes[i].getWidth(),boxes[i].getHeight() );
	      }
	      
	      // write your code for start time
	      long startTime = System.nanoTime();
	      boxes_bubble = bubbleSort(boxes_bubble);
	      // write your code for end time
	      long stopTime = System.nanoTime();
	      // Calculate execution time for bubble sort
		  System.out.println("For array size: "+n+" Execution time bubble sort: "+(stopTime - startTime)/1000000.0 + " miliSec");
	      
	      
	      //write your code for start time
		  startTime = System.nanoTime();
	      boxes_selection = selectionSort(boxes_selection);
	      //write your code for end time
	      stopTime = System.nanoTime();
	      // Calculate execution time for selection sort
		  System.out.println("For array size: "+n+" Execution time selection sort: "+(stopTime - startTime)/1000000.0 + " miliSec");
	      
	      
	      // Version 3
	      /* write your code for start time
	       * Write Arrays.sort() for Box objects
	       * write your code for end time
	       * Calculate execution time for Arrays.sort()
	       */
	      
	      // Complete the bellow comparator class
	      class BoxVolumeComparator implements Comparator<Box> {
	    	    @Override
	    	    public int compare(Box box1, Box box2) {
	    	    	if(box1.getVolume()<box2.getVolume()){
	    	    		return -1;
	    	    	}else if(box1.getVolume()>box2.getVolume()){
	    	    		return 1;
	    	    	}else
	    	    		return 0;
	    	    }
	    	}
	      startTime = System.nanoTime();
	      Arrays.sort(boxes_arrays_sort, new BoxVolumeComparator());
	      stopTime = System.nanoTime();
	      System.out.println("For array size: "+n+" Execution time array sort: "+(stopTime - startTime)/1000000.0 + " miliSec");
	      
//	      for(int i=0; i<boxes.length; i++) {
//	    	  System.out.println(boxes_bubble[i].getVolume());
//	      }
//	      for(int i=0; i<boxes.length; i++) {
//	    	  System.out.println(boxes_selection[i].getVolume());
//	      }
//	      for(int i=0; i<boxes.length; i++) {
//    	  System.out.println(boxes_arrays_sort[i].getVolume());
//      }

	}
	// Generating random boxes of size n
	public static Box[] randomBoxes(int n) {
		int i=0;
		Box boxes[] = new Box[n];

		//creating object of random class
		Random r = new Random();
	      while(i<n){					

		        Box box = new Box();
		        //creates random numbers
				double length=r.nextDouble()*10;					
				box.setLength(length);										
				  
				double width=r.nextDouble()*10;					
				box.setWidth(width);
				  
				double height=r.nextDouble()*10;
				box.setHeight(height);

				  boxes[i]=box;
		          i++;
		          
			  }
	      return boxes;
	}
	
	public static Box[] bubbleSort(Box boxes[]) {
		// sort according to volume
		int n = boxes.length;
		double temp = 0;
		for(int i=0; i<n; i++){
			for(int j=1; j<(n-i); j++){
				if(boxes[j-1].getVolume()>boxes[j].getVolume()){
					temp = boxes[j-1].getVolume();
					boxes[j-1] = boxes[j];
					temp = boxes[j].getVolume();
				}
			}
		}
		return boxes;
	}
	
	public static Box[] selectionSort(Box boxes[]) {
		// sort according to volume
		for(int i=0; i<boxes.length-1; i++){
			int minIndex = i;
			for(int j=i+1; j<boxes.length; j++){
				if(boxes[minIndex].getVolume()>boxes[j].getVolume()){
					minIndex = j;
				}
			}
			if(minIndex!=i){
				double temp = boxes[i].getVolume();
				boxes[i] = boxes[minIndex];
				temp = boxes[minIndex].getVolume();
			}
		}
		return boxes;
	}

}


