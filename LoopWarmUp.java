//Given an array of strings, print each string to ts own line on the console

//Using a standard for loop
for(int i = 0; i < a.length; i++)
{
  System.out.println(a[i]);
}

//Using an enhanced for loop (for-each loop)
//For each string s in array a, do this
for(String s: a)
{
  System.out.println(s);
}

//When would I want to use an enhanced for loo?
//Use for each when you want to do the same thing to each element in the array, but you don't care about the index