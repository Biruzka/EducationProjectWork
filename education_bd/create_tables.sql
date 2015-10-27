
CREATE TABLE students (
	id				SERIAL			PRIMARY KEY,
	sername			VARCHAR(70)		NOT NULL,
	sex				VARCHAR(1)		NOT NULL,
	group_id		INT,
	living_place	VARCHAR(30),

	CHECK (sex = 'm' or sex = 'w'),
);

CREATE TABLE teachers (
	id				SERIAL			PRIMARY KEY,
	sername			VARCHAR(70)		NOT NULL,
	department		VARCHAR(70)		NOT NULL,
	charge			INT, //СВЯЗАТЬ С ЗАНЯТИЯМИ
	faculty			VARCHAR(70)		NOT NULL	
);

CREATE TABLE subjects (
	id				SERIAL			PRIMARY KEY,
	name			VARCHAR(70)		NOT NULL,
	final_report	VARCHAR(1)		NOT NULL DEFAULT 'test',
	hours			INT				NOT NULL,
	type			VARCHAR(70)		NOT NULL DEFAULT 'lection',	

	CHECK (hours>=0),
	CHECK (final_report = 'test' or final_report = 'control' or final_report = 'exam'),
	CHECK (type = 'lection' or type = 'practice')

);

CREATE TABLE groups (
	id					SERIAL			PRIMARY KEY,
	cod					VARCHAR(70)		NOT NULL,
	students_count		INT				NOT NULL,
	faculte				VARCHAR(70)		NOT NULL,
	praepostor_student	INT				REFERENCES students (id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE lessons (
	teacher_id		INT 			REFERENCES techers (id) ON DELETE SET NULL ON UPDATE CASCADE,
	group_id		INT 			REFERENCES groups (id) ON DELETE SET NULL ON UPDATE CASCADE,
	subject_id		INT 			REFERENCES subjects (id) ON DELETE SET NULL ON UPDATE CASCADE,
	semester		INT				NOT NULL,
	auditorium		INT				NOT NULL,
	time			TIMESTAMP		NOT NULL	
);
	
