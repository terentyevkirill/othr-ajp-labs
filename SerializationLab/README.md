## Implement the given requirements / try to answer the given questions:
#### 1. Make class Employee serializable and store some objects on the file system and deserialize them afterwards.
We have to make Person class implement Serializable. Then its child, Employee class will be serializable as well.
#### 2. What would be  reasonable file names for the serialized objects?
It is a good practice to give such files `.ser` extension, because it helps to understand easily, 
that this file contains serialized data and therefore can be de-serialized.
#### 3. What is the average size (in bytes) of the serialized objects? (Use ByteArrayOutputStream instead of other streams.)
Using ByteArrayOutputStream it is about 1450 chars. If we check the size of created file, it will be the same (for same object, of course).
#### 4. Improve the serialization in order to allow for a optimal minimum “serialization size” (be reasonable, no need to squeeze the last byte out of the mechanism)

