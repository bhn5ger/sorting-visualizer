# Wavelength Sorting Visualizer by Brian N.
This is a unique application is for visualizing sorting algorithms; it sorts cycles of a wave from least to greatest wavelength until the wave looks like a spring stretched from one end. Traversal, comparison, and swapping of the cycles of the wave are animated during real time sorting using colors and threads. To use it yourself, 

[![button](https://user-images.githubusercontent.com/72827220/105613682-168ed580-5d92-11eb-9950-17b6c423c19b.png)](https://drive.google.com/uc?id=1LLblZcjqLiA1N0F-BB0DEEGDy8JPzbXU&export=download)


## Control Panel ##
The control panel is aligned horizontally at the bottom of the frame and contains 5 components: a button to add cycles, a button to clear cycles, a drop down menu to select a sorting algorithm, a slider to set animation speed, and a button to initiate sorting. The add cycle button generates a cycle to the frame with a random wavelength from 51 to 90, and can be pressed until the wave reaches the end of the frame. The clear button removes all cycles from the frame, deleting the entire wave. At the time of this writing, there is no way to add a cycle with a particular wavelength or location or remove a particular cycle. The drop down menu allows you to choose from selection sort, insertion sort, bubble sort, or merge sort. The farther to the right the slider, the faster the animation speed. Clicking the sort button will not initiate sorting unless there are cycles on the frame and a sorting algorithm is selected. While sorting, the control panel is disabled.

![controlPanel3](https://user-images.githubusercontent.com/72827220/104863792-13fd2d80-5905-11eb-8064-4a81cffe3ef8.gif)

## Selection Sort ##
Selection sort works by finding the smallest element in the unsorted sublist, swapping it with the leftmost unsorted element, and moving the sublist boundaries one element to the right. 

![selectionSort3](https://user-images.githubusercontent.com/72827220/104863807-1e1f2c00-5905-11eb-9849-2957cb62b5c7.gif)

As seen in the visualizer, the solid green represents the leftmost unsorted element to be swapped (if necessary), the solid red represents the smallest element in the unsorted sublist, and the flashing red represents comparisons made during traversal of the unsorted sublist.

## Insertion Sort ##
Insertion sort works by splitting the array into a sorted and an unsorted part; values from the unsorted part are picked and placed at the correct position in the sorted part. 

![insertionSort3](https://user-images.githubusercontent.com/72827220/104863840-355e1980-5905-11eb-9aba-4faa985bf373.gif)

As seen in the visualizer, the solid green represents the last element (i.e. the greatest element, since it is sorted in ascending order) of the sorted part while the flashing red represents values from the unsorted part being compared and swapped into the correct position in the sorted part.

## Bubble Sort ##
Bubble sort works by repeatedly swapping the adjacent elements if they are in wrong order. 

![bubbleSort3](https://user-images.githubusercontent.com/72827220/104863852-3f801800-5905-11eb-9343-bd85bfefe66c.gif)

As seen in the visualizer, the flashing red represents the adjacent elements being compared and swapped (if necessary).

## Merge Sort ##
Merge sort works by dividing the input array into two halves, calling itself for the two halves, and then merging the two sorted halves. 

![mergeSort3](https://user-images.githubusercontent.com/72827220/104863860-4ad34380-5905-11eb-9cd0-ae7b16e47d0c.gif)

Since this sorting algorithm is more complicated than the three above, the visualizer has three color animations: solid green, solid blue, and flashing red. The solid green represents the left and right elements of the subarrays during merging. The solid blue represents the middle element of the subarrays during merging. And finally, the flashing red represents elements from the subarrrays being compared during merging and also the resulting sorted array after merging the subarrays.

## Unit Testing ##
To make sure sorting works properly (wavelengths are sorted in ascending order), JUnit tests were written for each sorting algorithm. As seen below, each algorithm implementation worked as expected.

![tests3](https://user-images.githubusercontent.com/72827220/104863874-545cab80-5905-11eb-98c4-f9c7dc6e8152.gif)

## To be implemented ##
Heap sort, quick sort, radix sort, and more sorting algorithms are to be implemented. Additionally, a feature to increase the range of wavelengths generated (which is currently 51 to 90) to help differentiate cycles more visually is in progress.

