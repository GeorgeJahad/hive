package org.apache.hadoop.hive;

import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.hdfs.server.namenode.DefaultINodeAttributesProvider;
import org.apache.hadoop.hdfs.server.namenode.INode;
import org.apache.hadoop.hdfs.server.namenode.INodeAttributes;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HDFSBypass extends DefaultINodeAttributesProvider {

  static final private Logger LOG = LoggerFactory.getLogger("HDFSBypass");

  @Override
  public AccessControlEnforcer getExternalAccessControlEnforcer(
      AccessControlEnforcer defaultEnforcer) {
    return new AccessControlEnforcer() {
      @Override
      public void checkPermission(String fsOwner, String supergroup,
                                  UserGroupInformation callerUgi,
                                  INodeAttributes[] inodeAttrs, INode[] inodes,
                                  byte[][] pathByNameArr, int snapshotId,
                                  String path, int ancestorIndex,
                                  boolean doCheckOwner, FsAction ancestorAccess,
                                  FsAction parentAccess, FsAction access,
                                  FsAction subAccess, boolean ignoreEmptyDir)
      {
        LOG.info("HDFSBypass checkPermission");
      }
      @Override
      public void checkPermissionWithContext(AuthorizationContext authzContext)
      {
        LOG.info("HDFSBypass checkPermissionWithContext");
      }
    };
  }

}
