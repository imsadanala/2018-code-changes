-> Interface which has one abstract method and multiple default and static methods is called Functional interface.

-> To create a custom functional interface use  @FunctionalInterface

-> We can implement the Functional programming in java using Lambda expression

-> Lambda expression won't generate the ".class " files

Java8 has given below pre-defined functional interfaces
1. Consumer Interface
has method (i.e. accepts) that accepts T type as parameter and returns void.
2. Predicate Interface
has method (i.e. test) that accepts T type as parameter and returns boolean
4. Supplier Interface
has method ( i.e. get) that accepts no argument and returns the T type

Stream 
- is abstraction
- a view of date how data is transformed
- is a pipeline
 use of stream
 - raise the concrete collection to stream
 - ride the stream
 - compose the operations (i.e series of operations)
 
 source
 - Stream takes Collections, Arrays, or I/O resources as input source.
 
 specialized functions
 - filter
 - map , mapToInt ..
 - List, Set, Map, groupingBy
 - sorting, sorting with comparing
 - sum, max, min, 
  
  Stream operations are specilized into intermediate and terminal operations,
  
   intermediate
   
   - these operations are always return new streams lazily
   - filter , map related funcions
   - stream.filter() doesn't actually perform any filtering but insteads creates a new stream for that, when transversed, contains the elements of the initial stream that match the given predicate. Transversal of the pipeline does begin until terminal operation of the pipeline is called/executed.
   
   terminal
   
   - foreach, sum so on related functions
   - these operations performed, stream pipepline in consumed and no longer can be used eagerily  
 
 Characteristics needs to keep in mind while working with collections
  - sized, ordered, distinct, sorted
 
 we shouldn't mutating the variable in the streams for eg, add operation in the for loop which leads to concurrency issues instead use collect(which uses the temp variable for new arraylist) that handles all
 
 Reference link : https://www.youtube.com/watch?v=rVfRDLIw_Zw&t=3001s
 
  
 
