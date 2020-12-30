# Wavelength Sorting Visualizer by Brian N.
This application is for visualizing sorting algorithms; it sorts cycles of a wave from least to greatest wavelength until the wave looks like a spring stretched from one end. Traversal and swapping of the cycles of the wave are animated during real time sorting using colors and threads.

## Control Panel ##
The control panel is aligned horizontally at the bottom of the frame and contains 5 components: a button to add cycles, a button to clear cycles, a drop down menu to select a sorting algorithm, a slider to set animation speed, and a button to initiate sorting. The add cycle button generates a cycle to the frame with a random wavelength from 51 to 90, and can be pressed until the wave reaches the end of the frame. The clear button removes all cycles from the frame, deleting the entire wave. At the time of this writing, there is no way to add a cycle with a particular wavelength or location or remove a particular cycle. The drop down menu allows you to choose from selection sort, insertion sort, bubble sort, or merge sort. The farther to the right the slider, the faster the animation speed. Clicking the sort button will not initiate sorting unless there are cycles on the frame and a sorting algorithm is selected. While sorting, the control panel is disabled.

![controlPanel](https://user-images.githubusercontent.com/72827220/103315789-a5f3d380-49f4-11eb-8021-fe921c766353.gif)

## Selection Sort ##
Selection sort works by finding the smallest element in the unsorted sublist, swapping it with the leftmost unsorted element, and moving the sublist boundaries one element to the right. 

As seen in the visualizer, the solid green represents the leftmost unsorted element to be swapped (if necessary), the solid red represents the smallest element in the unsorted sublist, and the flashing red represents comparisons made during traversal of the unsorted sublist.

![selectionSort](https://user-images.githubusercontent.com/72827220/103316927-fde00980-49f7-11eb-9981-cd6e7d738789.gif)

## Insertion Sort ##
Insertion sort works by splitting the array into a sorted and an unsorted part; values from the unsorted part are picked and placed at the correct position in the sorted part. 

As seen in the visualizer, the solid green represents the last element (i.e. the greatest element, since it is sorted in ascending order) of the sorted part while the flashing red represents values from the unsorted part being compared and swapped into the correct position in the sorted part.

![insertionSort](https://user-images.githubusercontent.com/72827220/103324732-c2086c80-4a16-11eb-8063-aaf7eaa58a0d.gif)

## Bubble Sort ##
Bubble sort works by repeatedly swapping the adjacent elements if they are in wrong order. 

As seen in the visualizer, the flashing red represents the adjacent elements being compared and swapped (if necessary).

![bubbleSort](https://user-images.githubusercontent.com/72827220/103325141-67701000-4a18-11eb-8b41-233314ac5098.gif)

## Merge Sort ##
Merge sort works by dividing the input array into two halves, calling itself for the two halves, and then merging the two sorted halves. 

Since this sorting algorithm is more complicated than the three above, the visualizer has three color animations: solid green, solid blue, and flashing red. The solid green represents the left and right elements of the subarrays during merging. The solid blue represents the middle element of the subarrays during merging. And finally, the flashing red represents elements from the subarrrays being compared during merging and also the resulting sorted array after merging the subarrays.

![mergeSort](https://user-images.githubusercontent.com/72827220/103325938-17934800-4a1c-11eb-8500-a089d08cf9e3.gif)

## Unit Testing ##
To make sure sorting works properly (wavelengths are sorted in ascending order), JUnit tests were written for each sorting algorithm. As seen below, each algorithm implementation worked as intended.

![tests](https://user-images.githubusercontent.com/72827220/103370918-19045500-4a9c-11eb-8483-9ba026d1913f.gif)

## To be implemented ##
Heap sort, quick sort, radix sort, and more sorting algorithms are to be implemented. Additionally, a feature to increase the range of wavelengths generated (which is currently 51 to 90) to help differentiate cycles more visually is in progress.


© 2020 Brian Nguyen
