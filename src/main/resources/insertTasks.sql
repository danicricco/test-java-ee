insert into assignees (id, name, email) values (1, 'John Smith', 'jsmith@gmail.com');
insert into assignees (id, name, email) values (2, 'Jane Doe', 'jdoe@gmail.com');
insert into assignees (id, name, email) values (3, 'Steve Jones', 'sjones@gmail.com');


insert into tasks (id, description, assignee, due) values (1, 'Implement REST service for task list.', 1, timestamp '2013-09-01 17:00:00');

insert into tasks (id, description, assignee, due, completed_at) values (2, 'Design GUI for task list signup form.', 2, timestamp '2013-09-02 12:00:00', timestamp '2013-08-29 13:42:22');

insert into tasks (id, description, assignee, due) values (3, 'Find first customer for task list app.', 3, timestamp '2013-10-01 08:00:00');

insert into tasks (id, description, assignee, due) values (4, 'Fix all bugs in task list app.', null, null);

insert into tasks (id, description, assignee, due) values (5, 'Add email reminds to task list app.', null, null);
