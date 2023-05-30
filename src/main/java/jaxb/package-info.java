/**
 * This package provides a helper class for working with JAXB (Java Architecture for XML Binding).
 *
 * <p>JAXBHelper class:
 * The {@code JAXBHelper} the class helps to serialize xml files.
 *
 * <p>Usage examples:
 * <pre>{@code
 *     // Serialize an object to XML
 *     MyObject obj = new MyObject();
 *     OutputStream os = new FileOutputStream("output.xml");
 *     JAXBHelper.toXML(obj, os);
 *
 *     // Deserialize an object from XML
 *     InputStream is = new FileInputStream("input.xml");
 *     MyObject newObj = JAXBHelper.fromXML(MyObject.class, is);
 * }</pre>
 */
package jaxb;