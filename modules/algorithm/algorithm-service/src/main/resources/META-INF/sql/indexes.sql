create index IX_C66B0449 on FOO_ALGTree (groupId, status);
create index IX_A4C43E5B on FOO_ALGTree (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FF6E9F9D on FOO_ALGTree (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A0A356FC on FOO_TreeNode (groupId, treeId, level);
create index IX_316A3013 on FOO_TreeNode (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_89D59F55 on FOO_TreeNode (uuid_[$COLUMN_LENGTH:75$], groupId);