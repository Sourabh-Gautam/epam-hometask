create table quizes (
	quiz_id int auto_increment,
    quiz_title varchar(255),
    primary key (quiz_id)
);

create table questions (
	question_id int auto_increment,
    question_statement varchar(510),
    question_quiz_id int,
    primary key (question_id),
    foreign key (question_quiz_id) references quizes(quiz_id) on delete cascade
);

create table options (
	option_id int auto_increment,
    option_name varchar(255),
    is_correct bit,
    option_question_id int,
    primary key (option_id),
    foreign key (option_question_id) references questions(question_id) on delete cascade
);