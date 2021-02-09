# Wavelength Sorting Visualizer by Brian N.
This is an application is for visualizing sorting algorithms; it sorts cycles of a wave from least to greatest wavelength until the wave looks like a spring stretched from one end. Traversal, comparison, and swapping of the cycles of the wave are animated during real time sorting using colors and threads. To use it yourself, 

[![button](https://user-images.githubusercontent.com/72827220/105613682-168ed580-5d92-11eb-9950-17b6c423c19b.png)](https://drive.google.com/uc?id=1qgB0-jYm2kI1IF3ViTLA3PErsq0AmI6D&export=download)


## Control Panel ##
The control panel is aligned horizontally at the bottom of the frame and contains 6 components: a button to generate a wave, a button to add cycles, a button to clear cycles, a drop down menu to select a sorting algorithm, a slider to set animation speed, and a button to initiate sorting. The generate wave button generates 10-14 cycles instantly to form a complete wave on the frame. The add cycle button generates a cycle to the frame with a random wavelength from 51 to 100, and can be pressed until the wave reaches the end of the frame. The clear button removes all cycles from the frame, deleting the entire wave. At the time of this writing, there is no way to add a cycle with a particular wavelength or location or remove a particular cycle. The drop down menu allows you to choose from selection sort, insertion sort, bubble sort, or merge sort. The farther to the right the slider, the faster the animation speed. Clicking the sort button will not initiate sorting unless there are cycles on the frame and a sorting algorithm is selected. While sorting, the control panel is disabled.

![controlPanel4](https://user-images.githubusercontent.com/72827220/107428698-09434c00-6af1-11eb-9343-2f4bfe89b1aa.gif)

## Selection Sort ##
Selection sort works by finding the smallest element in the unsorted sublist, swapping it with the leftmost unsorted element, and moving the sublist boundaries one element to the right. 

![selectionSort4](https://user-images.githubusercontent.com/72827220/107428734-13654a80-6af1-11eb-9692-60619864485f.gif)

As seen in the visualizer, the solid green represents the leftmost unsorted element to be swapped (if necessary), the solid red represents the smallest element in the unsorted sublist, and the flashing red represents comparisons made during traversal of the unsorted sublist.

## Insertion Sort ##
Insertion sort works by splitting the array into a sorted and an unsorted part; values from the unsorted part are picked and placed at the correct position in the sorted part. 

![insertionSort4](https://user-images.githubusercontent.com/72827220/107428795-1fe9a300-6af1-11eb-8589-e379d0216510.gif)

As seen in the visualizer, the solid green represents the last element (i.e. the greatest element, since it is sorted in ascending order) of the sorted part while the flashing red represents values from the unsorted part being compared and swapped into the correct position in the sorted part.

## Bubble Sort ##
Bubble sort works by repeatedly swapping the adjacent elements if they are in wrong order. 

![bubbleSort4](https://user-images.githubusercontent.com/72827220/107428838-2c6dfb80-6af1-11eb-80dd-754855bcd444.gif)

As seen in the visualizer, the flashing red represents the adjacent elements being compared and swapped (if necessary).

## Merge Sort ##
Merge sort works by dividing the input array into two halves, calling itself for the two halves, and then merging the two sorted halves. 

![mergeSort4](https://user-images.githubusercontent.com/72827220/107428874-3a238100-6af1-11eb-8f70-94e5674d23d2.gif)

Since this sorting algorithm is more complicated than the three above, the visualizer has three color animations: solid green, solid blue, and flashing red. The solid green represents the left and right elements of the subarrays during merging. The solid blue represents the middle element of the subarrays during merging. And finally, the flashing red represents elements from the subarrrays being compared during merging and also the resulting sorted array after merging the subarrays.

## Unit Testing ##
To make sure sorting works properly (wavelengths are sorted in ascending order), JUnit tests were written for each sorting algorithm. As seen below, each algorithm implementation worked as expected.

![tests4](https://user-images.githubusercontent.com/72827220/107428897-44457f80-6af1-11eb-8510-6bb9da795bc2.gif)

## To be implemented ##
Heap sort, quick sort, radix sort, and more sorting algorithms are to be implemented. Additionally, a feature to increase the range of wavelengths generated (which is currently 51 to 100) to help differentiate cycles more visually is in progress.

