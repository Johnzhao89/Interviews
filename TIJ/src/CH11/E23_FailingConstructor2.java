package CH11;
/****************** Exercise 23 *****************
 * Add a class with a dispose() method to the
 * previous exercise. Modify FailingConstructor so
 * that the constructor creates one of these
 * disposable objects as a member object, after which
 * the constructor might throw an exception, after
 * which it creates a second disposable member object.
 * Write code to properly guard against failure, and
 * in main() verify that all possible failure
 * situations are covered.
 ***********************************************/