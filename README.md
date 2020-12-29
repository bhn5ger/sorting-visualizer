# Wavelength Sorting Visualizer
This application is for visualizing sorting algorithms; it sorts cycles of a wave from least to greatest wavelength until it looks like a spring stretched from one end. Traversal and swapping of the cycles of the wave are animated during real time sorting using colors and threads.

## Control Panel ##
The control panel is aligned horizontally the bottom of the frame and contains 5 components: a button to add cycles, a button to clear cycles, a drop down menu to select a sorting algorithm, a slider to set animation speed, and a button to initiate sorting. The add cycle button generates a cycle to the frame with a random wavelength from 51 to 90, and can be pressed until the wave reaches the end of the frame. The clear button removes all cycles from the frame, deleting the entire wave. At the time of this writing, there is no way to add a cycle with a particular wavelength or location or remove a particular cycle. The drop down menu allows you to choose from selection sort, insertion sort, bubble sort, or merge sort. The farther to the right the slider, the faster the animation speed. Clicking the sort button will not initiate sorting unless there are cycles on the frame and a sorting algorithm is selected. While sorting, the control panel is disabled.

                            ![controlPanel](https://user-images.githubusercontent.com/72827220/103315789-a5f3d380-49f4-11eb-8021-fe921c766353.gif)

## Selection Sort ##

## Insertion Sort ##

## Bubble Sort ##

## Merge Sort ##
