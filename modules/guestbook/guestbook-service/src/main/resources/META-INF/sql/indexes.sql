create index IX_13858188 on GBB_Entry (groupId, guestbookId, status);
create index IX_77028C14 on GBB_Entry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9E270796 on GBB_Entry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1A682C1 on GBB_Guestbook (groupId, status);
create index IX_D0F88EE3 on GBB_Guestbook (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D80D7225 on GBB_Guestbook (uuid_[$COLUMN_LENGTH:75$], groupId);