-- ColorMemos 데이터베이스

-- 사용자 생성
CREATE USER ColorMemos
IDENTIFIED BY cm123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

-- 계정 권한 부여
GRANT CONNECT TO ColorMemos;
GRANT RESOURCE TO ColorMemos;
GRANT DBA TO ColorMemos;
commit;

-- 테이블 삭제
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE MEMO CASCADE CONSTRAINTS;

-- 테이블 생성
/* 회원 */
CREATE TABLE MEMBER (
	EMAIL VARCHAR2(1000) NOT NULL, /* 회원아이디 */
	PASSWORD VARCHAR(50) NOT NULL, /* 회원비밀번호 */
	USERNAME VARCHAR(50) NOT NULL /* 회원이름 */
);

ALTER TABLE MEMBER
	ADD
		CONSTRAINT PK_MEMBER
		PRIMARY KEY (
			EMAIL
		);
        
/* 메모 */
CREATE TABLE MEMO (
    MNO            NUMBER(10,0) NOT NULL,      /* 메모번호 */
    MNAME          VARCHAR2(100) NOT NULL,     /* 메모제목 */
    MDESCRIPTION   VARCHAR2(4000) NOT NULL,    /* 메모 */
	REGDAY         DATE,                       /* 메모작성일 */
    REGID          VARCHAR2(1000) NOT NULL,    /* 메모작성자 */
    MCOLOR         VARCHAR2(1000) NOT NULL,    /* 메모색상 */
	HIDE_GB        NUMBER DEFAULT 0 NOT NULL,  /* 숨김구분 */
    FAVORITE_GB    NUMBER DEFAULT 0 NOT NULL,  /* 즐겨찾기구분 */
    DELETE_GB      NUMBER DEFAULT 0 NOT NULL,  /* 삭제구분 */
    DELT_DATE      DATE,                       /* 메모삭제일 */
	RESTORE_DATE   DATE                        /* 메모복구일 */
);

ALTER TABLE MEMO
	ADD
		CONSTRAINT PK_MEMO
		PRIMARY KEY (
			MNO
		);

-- 메모 테이블 시퀀스 MNO
CREATE SEQUENCE MEMO_SEQ INCREMENT BY 1; 



SELECT  * FROM MEMBER;
SELECT  * FROM MEMO;
       