## Implement the given requirements / try to answer the given questions:
#### 1. Make class Employee serializable and store some objects on the file system and deserialize them afterwards.
We have to make Person class implement Serializable. Then its child, Employee class will be serializable as well.
#### 2. What would be  reasonable file names for the serialized objects?
It is a good practice to give such files `.ser` extension, because it helps to understand easily, 
that this file contains serialized data and therefore can be de-serialized.
#### 3. What is the average size (in bytes) of the serialized objects? (Use `ByteArrayOutputStream` instead of other streams.)
Using `ByteArrayOutputStream` it is about 1450 bytes. If we check the size of created file, it will be the same (for same object, of course).
#### 4. Improve the serialization in order to allow for a optimal minimum “serialization size” (be reasonable, no need to squeeze the last byte out of the mechanism)
We can use `java.util.zip` API to compress serialized data, namely `GZIPOutputStream` and `GZIPInputStream`. The size of serialized object reduced to 922 bytes, compared to 1450 without compressing.
#### 5. Name three major differences between serialization using `Externalizable` and `Serializable` interfaces
1. `Serializable` provides "automatic" serialization during the runtime using reflection. We don't have to perform it manually unless we really need it, and even if we need to deal with some fields manually, other fields can be dealt automatically (by default);
2. `Externalizable` needs marshalling and unmarshalling functions `writeExternal()` and `readExternal()` to be implemented manually. There is no possibility to perform serialization automatically even for certain fields of simple types;
3. During `Serializable` deserialization object is re-created entirely from serialized data, without calling a constructor. With `Externalizable`, default empty constructor is called at first to create an empty object.
#### 6. Can `Externalizable` objects be serialized using the built in serialization mechanism? If so, why or how? If not, why not?
No, they can't. Because `Externalizable` classes have to implement marshalling and unmarshalling functions manually, and there is no way to call `defaultWriteObject()` or `defaultReadObject()`, 
because `writeExternal()` and `readExternal()` receive directly `ObjectOutput` or `ObjectInput` objects as parameters, and not the Streams.
#### 7. Improve the Employee class further in order to be able to serialize and deserialize object states of different future versions of Employee class (e.g. add new field dateHired)
Added `static final long serialVersionUID` field, compiled class, serialized. After that brought some changes 
(new field `dateHired` and changed `toString()` implementation) and performed deserialization. As a result, `dateHired=null`, but serialization was performed. 
#### 8. Elaborate shortly how you could deal with “sensitive data”?
We can mark such fields as `transient`, than they won't be serialized and during deserialization they will be set to default values - 0/null/false.
