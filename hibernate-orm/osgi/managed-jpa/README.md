# Hibernate ORM OSGi Tutorial: Managed JPA through Enterprise OSGi JPA

This tutorial demonstrates the use of Enterprise OSGi JPA to create a "managed JPA" environment in your OSGi container.
More specifically, this is based on Apache Karaf 3.0.5 and Apache Aries JPA.  See the Hibernate ORM User Guide's OSGi
chapter for more information!

## Running the Tutorial
###simplified installation, just run mvn clean install

To run the tutorial, use the following commands in the Karaf console:

- feature:repo-add mvn:org.hibernate.osgi/managed-jpa/1.0.0/xml/features
- feature:install hibernate-osgi-managed-jpa
