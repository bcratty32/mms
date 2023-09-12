import java
import semmle.code.java.frameworks.spring.SpringBean

/**
 * Holds if `type` is `RemoteInvocationSerializingExporter`.
 */
predicate isRemoteInvocationSerializingExporter(RefType type) {
  type.getASupertype*()
      .hasQualifiedName("org.springframework.remoting.rmi", "RemoteInvocationSerializingExporter")
}

from SpringBean bean
where isRemoteInvocationSerializingExporter(bean.getClass())
select bean, "Unsafe deserialization in a Spring exporter bean '" + bean.getBeanIdentifier() + "'"