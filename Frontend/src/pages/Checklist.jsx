import React, { useState, useEffect } from 'react';
import './Checklist.css';

export default function Checklist() {
    const initialItems = [
        { label: 'Máscara 😷', desc: 'Proteção respiratória', checked: false },
        { label: 'Água 💧', desc: '1L por pessoa', checked: true },
        { label: 'Documentos 📄', desc: 'RG, CPF, carteira', checked: true },
        { label: 'Lanterna 🔦', desc: 'Com pilhas extras', checked: true },
        { label: 'Kit Primeiros Socorros 🩹', desc: 'Básico', checked: false },
        { label: 'Medicamentos 💊', desc: 'Uso contínuo', checked: false },
        { label: 'Celular carregado 📱', desc: '+ carregador', checked: false },
        { label: 'Rádio portátil 📻', desc: 'Para emergências', checked: false },
    ];

    const [items, setItems] = useState(initialItems);
    const [showToast, setShowToast] = useState(false);

    const checkedCount = items.filter(i => i.checked).length;

    const handleCheck = (index) => {
        const updated = [...items];
        updated[index].checked = !updated[index].checked;
        setItems(updated);
        setShowToast(true);
    };

    useEffect(() => {
        if (showToast) {
            const timer = setTimeout(() => setShowToast(false), 2000);
            return () => clearTimeout(timer);
        }
    }, [showToast]);

    return (
        <div className="bg-gray-50 min-h-screen pb-24">
            {/* Toast */}
            {showToast && (
                <div className="fixed top-16 left-4 right-4 z-50 bg-green-500 text-white px-4 py-3 rounded-lg shadow-lg animate-slideIn">
                    <div className="flex items-center">
                        <i className="fas fa-check-circle text-xl mr-3" />
                        <span className="font-medium">Bom trabalho! Item concluído ✨</span>
                    </div>
                </div>
            )}

            {/* Header */}
            <header className="bg-white shadow-sm border-b border-gray-200">
                <div className="flex items-center justify-between px-4 py-4">
                    <button className="text-gray-600 hover:text-gray-800">
                        <i className="fas fa-arrow-left text-xl" />
                    </button>
                    <h1 className="text-lg font-bold text-gray-800">Checklist de Emergência</h1>
                    <button className="text-gray-600 hover:text-gray-800">
                        <i className="fas fa-ellipsis-v text-xl" />
                    </button>
                </div>
            </header>

            {/* Progress */}
            <div className="bg-white px-4 py-3 border-b border-gray-100">
                <div className="flex items-center justify-between mb-2">
                    <span className="text-sm text-gray-600">Progresso</span>
                    <span className="text-sm font-medium text-orange-600">{checkedCount} de {items.length} itens</span>
                </div>
                <div className="w-full bg-gray-200 rounded-full h-2">
                    <div
                        className="bg-orange-500 h-2 rounded-full transition-all duration-300"
                        style={{ width: `${(checkedCount / items.length) * 100}%` }}
                    ></div>
                </div>
            </div>

            {/* Lista */}
            <main className="px-4 py-4">
                <h2 className="text-lg font-semibold text-gray-800 mb-4 flex items-center">
                    <i className="fas fa-exclamation-triangle text-orange-500 mr-2" />
                    Itens Essenciais
                </h2>
                <div className="space-y-3">
                    {items.map((item, index) => (
                        <div
                            key={index}
                            className="bg-white rounded-lg p-4 shadow-sm border border-gray-100"
                        >
                            <div className="flex items-center">
                                <input
                                    type="checkbox"
                                    checked={item.checked}
                                    onChange={() => handleCheck(index)}
                                    className="w-5 h-5 text-orange-500 border-2 border-gray-300 rounded focus:ring-orange-500 mr-4"
                                />
                                <span
                                    className={`text-gray-800 font-medium flex-1 ${item.checked ? 'line-through opacity-60' : ''}`}
                                >
                                    {item.label}
                                </span>
                                <span className="text-sm text-gray-500">{item.desc}</span>
                            </div>
                        </div>
                    ))}
                </div>
            </main>

            {/* Botão flutuante */}
            <button
                className="fixed bottom-20 right-4 w-14 h-14 bg-orange-500 hover:bg-orange-600 text-white rounded-full shadow-lg flex items-center justify-center transition-all duration-300 hover:scale-110"
                onClick={() => {
                    const name = prompt('Digite o nome do novo item:');
                    if (name) {
                        setItems([...items, { label: name, desc: 'Personalizado', checked: false }]);
                    }
                }}
            >
                <i className="fas fa-plus text-xl" />
            </button>
        </div>
    );
}
