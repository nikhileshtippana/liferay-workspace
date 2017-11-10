create table FOO_ALGTree (
	uuid_ VARCHAR(75) null,
	treeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table FOO_TreeNode (
	uuid_ VARCHAR(75) null,
	treeNodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	value INTEGER,
	level INTEGER,
	parentId LONG,
	treeId LONG
);