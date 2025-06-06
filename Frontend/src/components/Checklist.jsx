import React, { useState, useEffect } from 'react';
import { fetchChecklist, createChecklist, updateChecklist, deleteChecklist } from '../api/checklist';
export function Checklist({ userId }) {
    const [items, setItems] = useState([]);
    useEffect(() => { fetchChecklist(userId).then(setItems); }, [userId]);
    const addItem = async () => { const it = await createChecklist({ userId, label: 'New', status:'P'}); setItems(prev=>[...prev,it]); };
    return (
        <div>
            <button onClick={addItem}>Add</button>
            {items.map(it => <div key={it.id}>{it.label} [{it.status}]</div>)}
        </div>
    );
}
