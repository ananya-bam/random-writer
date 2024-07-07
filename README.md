# random-writer
This project deals with probability-based text creation based on a given text file. Given a text file, the code picks a seed (of a given length), and picks a following character based on the probability that it occurs afterwards in the original source text. The goal of this was to create a resulting text file that looks somewhat similar to the original because it randomly produces text that has characters based on the probability with which each character follows every possible sequence of k characters.

I used the RandomWriter class, which implements the TextProcessor interface. TextProcessor has createProcessor(int level), readText(String inputFilename), and writeText(String outputFilename, int length). Within the RandomWriter class, there are the main, RandomWriter constructor, readText, and writeText methods. In my main method, I called the readText and writeText methods, which prints the output to a results file. 

I used an ArrayList to store the characters following the seed substring because they are mutable, and it is easily accessible. 

There are both positive and negative impacts of this form of technology. On the one hand, this can increase accessibility and make it easier for people to create content for things that don’t require everything to be handwritten. On the other hand, there are huge plagiarism issues with this technique. It is all copied from some original text that is most often not cited. Large language learning models cannot create anything original, but they can still help people gain new ideas and communicate more effectively. 
