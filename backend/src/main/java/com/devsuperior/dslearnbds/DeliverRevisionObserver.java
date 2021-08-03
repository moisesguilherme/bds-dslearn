package com.devsuperior.dslearnbds;

import com.devsuperior.dslearnbds.entities.Deliver;

public interface DeliverRevisionObserver {

	void onSaveRevision(Deliver deliver);

	
}
