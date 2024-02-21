INSERT INTO categories (category_name) VALUES ('IT');
INSERT INTO categories (category_name) VALUES ('Economy/Finance');
INSERT INTO categories (category_name) VALUES ('lifestylcategoriese');
INSERT INTO categories (category_name) VALUES ('Cooking/Baking');
INSERT INTO categories (category_name) VALUES ('Exercise/Fitness');
INSERT INTO categories (category_name) VALUES ('Photo/Video');
INSERT INTO categories (category_name) VALUES ('programming');
INSERT INTO categories (category_name) VALUES ('marketing');
INSERT INTO categories (category_name) VALUES ('design');
INSERT INTO categories (category_name) VALUES ('Video/Mindset');

INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (1, 567, 'IT 제목1', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail.png');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (1, 600, 'IT 제목2', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail.png');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (1, 720, 'IT 제목3', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail2.png');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (1, 480, 'IT 제목4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/+thumbnail/test-thumnail.png');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (2, 1020, '경제 제목1', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (2, 480, '경제 제목2', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (2, 1260, '경제 제목3', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (2, 300, '경제 제목4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (3, 420, '일상 제목1', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (3, 600, '일상 제목2', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (3, 480, '일상 제목3', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');
INSERT INTO videos (category_id, run_time, video_title, url, video_thumbnail) VALUES (3, 840, '일상 제목4', 'https://a-minute-society.s3.ap-northeast-2.amazonaws.com/videos/example.mp4', '');

INSERT INTO users (user_id, user_name, user_pw) VALUES ('hello', 'a', '1234');