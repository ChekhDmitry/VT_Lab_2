package by.chekh.server.service;

import by.chekh.entity.StudentCard;
import by.chekh.server.dao.FileDao;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by dima on 11/3/2017.
 */
public class ArchiveService {


    public  StudentCard findStudentCardByName(String studentName){
        List<StudentCard> localArchive = FileDao.loadArchive();
        for(StudentCard studentCard : localArchive){
            if(studentCard.getFullName().equals(studentName)){
                return studentCard;
            }
        }
        return null;
    }

    public boolean saveStudentCard(StudentCard studentCard){
        List<StudentCard> localArchive = FileDao.loadArchive();
        if(studentCard.getId() == 0){
            int maxId = 0;
            for(StudentCard archiveStudentCard : localArchive){
                if(archiveStudentCard.getId() > maxId){
                    maxId = archiveStudentCard.getId();
                }
            }
            maxId++;
            studentCard.setId(maxId);
            localArchive.add(studentCard);
        }else {
            Predicate<StudentCard> studentCardPredicate = archiveStudentCard -> archiveStudentCard.getId() == studentCard.getId();
            localArchive.removeIf(studentCardPredicate);
            localArchive.add(studentCard);
        }
        FileDao.saveArchive(localArchive);
        return true;
    }
}
