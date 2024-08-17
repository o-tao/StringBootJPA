package com.app.repository;

import com.app.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardEntityRepository extends JpaRepository<BoardEntity, Integer> {

    @Query(value = "select board2.board_no, board2.board_title, user2.user_nm, role2.role_nm " +
            "from board2, user2, urmapping, role2 " +
            "where board2.user_id = user2.user_id " +
            "and user2.user_id = urmapping.user_id " +
            "and urmapping.role_no = role2.role_no " +
            "order by 1",
            nativeQuery = true)
    public List<Boards> getBoards();

    @Query(value = "select b from board b join b.user")
    public List<BoardEntity> getBoardAll();

}
