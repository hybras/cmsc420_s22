module data_structures.project2.test {
    requires java.base;
    requires data_structures.project2;
    requires org.junit.jupiter.api;
    exports cmsc420_s22_test to org.junit.platform.commons;
    opens cmsc420_s22_test to org.junit.platform.commons;
}
