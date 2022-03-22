module data_structures.project1b.test {
    requires java.base;
    requires data_structures.project1b;
    requires org.junit.jupiter.api;
    exports cmsc420_s22_test to org.junit.platform.commons;
    opens cmsc420_s22_test to org.junit.platform.commons;
}
