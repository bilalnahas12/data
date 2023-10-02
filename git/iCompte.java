package git;

import java.util.List;

import git.operations.Operations;

public interface iCompte {
    void effectuerOperation(Operations operation);
    double getSolde();
    List<Operations> getOperations();
}

